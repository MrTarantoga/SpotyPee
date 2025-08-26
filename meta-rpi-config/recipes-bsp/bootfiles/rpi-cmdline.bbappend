CMDLINE_PATCH_WLAN_RPI3_ISSUE ?= "${@oe.utils.conditional("PATCH_RPI3_WLAN_ISSUE", "1", "brcmfmac.feature_disable=0x02000", "", d)}"
CMDLINE:prepend = " \
    ${CMDLINE_PATCH_WLAN_RPI3_ISSUE} \
"