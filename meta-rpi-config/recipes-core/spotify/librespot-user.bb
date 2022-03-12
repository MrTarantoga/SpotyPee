SUMMARY = "Example recipe for using inherit useradd"
LICENSE = "MIT"

SRC_URI = "\
    file://librespot.service \
"
S = "${WORKDIR}"

RDEPENDS:${PN} = "pulseaudio-volume"

inherit useradd

# how to
# pw: spotify
# at bash: usermod -p $(openssl passwd spotify) spotify
# get a salted hash: openssl passwd spotify
# one possible result: i0DKwgbqdsENM
# the command now looks: usermod -p i0DKwgbqdsENM spotify

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "--uid 1200 --home /home/spotify --system --shell /bin/sh --password i0DKwgbqdsENM --groups audio -g spotify spotify"
GROUPADD_PARAM:${PN} = "-g 880 spotify;"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "librespot.service"

do_install() {
    #User install
    install -d -m 755 ${D}/home/spotify

    #Systemd
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/librespot.service ${D}${systemd_system_unitdir}

    #Set user rights
    chown -R spotify ${D}/home/spotify
    chgrp -R spotify ${D}/home/spotify

}

FILES:${PN} = "/home/spotify"

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"