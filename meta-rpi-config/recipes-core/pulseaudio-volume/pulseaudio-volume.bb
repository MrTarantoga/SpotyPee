LICENSE = "MIT"
S = "${WORKDIR}"
SRC_URI = "file://pulseaudio_volume.service"


inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "pulseaudio_volume.service"

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/pulseaudio_volume.service ${D}${systemd_system_unitdir}
}