DESCRIPTION = "EResource monitor that shows usage and stats for processor, memory, disks, network and processes."
SECTION = "tools"
DEPENDS = "sed-native"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"


SRCREV	= "df205fb23c4d27bbe67d7e1bca4e7ee6f0e56a2f"
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
