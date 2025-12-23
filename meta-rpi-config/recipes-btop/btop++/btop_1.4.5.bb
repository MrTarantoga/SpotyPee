DESCRIPTION = "Resource monitor that shows usage and stats for processor, memory, disks, network and processes."
SECTION = "tools"
DEPENDS = "sed-native"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"


SRCREV	= "a1099d075fa914452366b28c67ff171e21a1f02e"
SRC_URI = "git://github.com/aristocratos/btop.git;branch=main;protocol=https"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "GPU_SUPPORT=false"

do_compile(){
    oe_runmake -e
}

do_install(){
    oe_runmake install DESTDIR=${D}
    chown root:root -R ${D}/usr/local/
}


FILES:${PN} = "/usr/local/"
