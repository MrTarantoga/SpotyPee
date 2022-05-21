LINUX_VERSION = "5.10.110"

SRCREV_machine = "e6f88767eac66b211361c85b5803fe71a4053959"
SRCREV_meta = "e1979ceb171bc91ef2cb71cfcde548a101dab687"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://add_cfg_5.10.cfg"

