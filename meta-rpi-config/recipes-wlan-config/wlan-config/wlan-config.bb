SUMMARY = "Create default wlan interface"

LICENSE = "MIT"

S = "${WORKDIR}"

python() {
    if not d.getVar("WLAN_PASSWORD"):
        bb.fatal("The variable  \"WLAN_PASSWORD\" is unset")

    if not d.getVar("WLAN_SSID"):
        bb.fatal("The variable \"WLAN_SSID\" is unset")
}

SRC_URI = "\
    file://wpa_supplicant-wlan0.conf \
    file://10-wifi.network \
    file://wpa_supplicant@wlan0.service \
"

FILES:${PN} = "\
    /etc/wpa_supplicant/wpa_supplicant-wlan0.conf \
    /etc/systemd/network/10-wifi.network \
    ${D}${systemd_system_unitdir}/wpa_supplicant@wlan0.service \
"


REQUIRED_DISTRO_FEATURES= "systemd"
RDEPENDS:${PN} = "wpa-supplicant"

inherit systemd

SYSTEMD_SERVICE:${PN} = "wpa_supplicant@wlan0.service"

python do_set_wifi_credentials(){
    wlan_ssid = d.getVar("WLAN_SSID").encode("ascii")
    psk = d.getVar("WLAN_PASSWORD").encode("ascii")

    from hashlib import pbkdf2_hmac
    psk_hash = pbkdf2_hmac("sha1", psk, wlan_ssid, 4096, 32).hex()

    config_file = d.getVar("S") + "/wpa_supplicant-wlan0.conf"
    with open(config_file, "r+") as file:
        fconfig = file.read()
        fconfig = fconfig.replace("${WLAN_SSID}", wlan_ssid.decode("ascii"))
        fconfig = fconfig.replace("${WLAN_PSK_HASH}", psk_hash)
        file.seek(0)
        file.write(fconfig)
}

do_module_install() {
    # Install wpa_supplicant configuration
    install -d ${D}/etc/wpa_supplicant/
    install -m 0655 ${S}/wpa_supplicant-wlan0.conf ${D}/etc/wpa_supplicant/wpa_supplicant-wlan0.conf

    # Install network files for systemd
    install -d ${D}/etc/systemd/network
    install -m 0655 ${S}/10-wifi.network ${D}/etc/systemd/network/10-wifi.network

    # Install systemd service
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/wpa_supplicant@wlan0.service ${D}${systemd_system_unitdir}

}

python do_install() {
    bb.build.exec_func("do_set_wifi_credentials", d)
    bb.build.exec_func("do_module_install", d)
}
