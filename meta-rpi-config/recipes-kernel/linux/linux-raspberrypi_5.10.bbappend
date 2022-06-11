LINUX_VERSION = "5.10.110"

SRCREV_machine = "427c6bd8835e197693e9b4aedbe45c2c3c84cdce"
SRCREV_meta = "e1979ceb171bc91ef2cb71cfcde548a101dab687"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://add_cfg_5.10.cfg"

