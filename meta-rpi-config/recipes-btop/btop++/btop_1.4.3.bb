DESCRIPTION = "Resource monitor that shows usage and stats for processor, memory, disks, network and processes."
SECTION = "tools"
DEPENDS = "sed-native"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"


SRCREV	= "3f1ccd9f6c455fef6d4d8cfbc8ed71b86961323d"
SRC_URI = "git://github.com/aristocratos/btop.git;branch=main;protocol=https"

S = "${WORKDIR}/git"
UNPACKDIR = "${S}"

EXTRA_OEMAKE = "GPU_SUPPORT=false"

do_compile(){
    cd git
    oe_runmake -e
}

do_install(){
    cd git
    oe_runmake install DESTDIR=${D}
    chown root:root -R ${D}/usr/local/
}


FILES:${PN} = "/usr/local/"
