DESCRIPTION = "EResource monitor that shows usage and stats for processor, memory, disks, network and processes."
SECTION = "tools"
DEPENDS = "sed-native"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"


SRCREV	= "76e26b0c518e99a9e207e4167a1162d0c2adeb36"
SRC_URI = "git://github.com/aristocratos/btop.git;branch=main"

S = "${WORKDIR}/git"

do_compile(){
	oe_runmake -e
}

do_install(){
    oe_runmake install DESTDIR=${D}
	chown root:root -R ${D}/usr/local/
}


FILES:${PN} = "/usr/local/"
