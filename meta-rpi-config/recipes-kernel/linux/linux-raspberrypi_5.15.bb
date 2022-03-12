LINUX_VERSION ?= "5.15.27"
LINUX_RPI_BRANCH ?= "rpi-5.15.y"
LINUX_RPI_KMETA_BRANCH ?= "yocto-5.15"

SRCREV_machine = "cad0c67b64bb9de6bc970c0a7afbccabec0fcf9d"
SRCREV_meta = "e1b976ee4fb5af517cf01a9f2dd4a32f560ca894"

KMETA = "kernel-meta"

SRC_URI = " \
    git://github.com/raspberrypi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    file://powersave.cfg \
    file://add_cfg_5.15.cfg \
    "


DESCRIPTION = "Linux Kernel for Raspberry Pi"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

COMPATIBLE_MACHINE = "^rpi$"

PE = "1"
PV = "${LINUX_VERSION}+git${SRCPV}"

inherit siteinfo
require recipes-kernel/linux/linux-yocto.inc

SRC_URI += " \
    ${@bb.utils.contains("INITRAMFS_IMAGE_BUNDLE", "1", "file://initramfs-image-bundle.cfg", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "vc4graphics", "file://vc4graphics.cfg", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wm8960", "file://wm8960.cfg", "", d)} \
    "
KCONFIG_MODE = "--alldefconfig"
KBUILD_DEFCONFIG:raspberrypi0-wifi ?= "bcmrpi_defconfig"
KBUILD_DEFCONFIG:raspberrypi ?= "bcmrpi_defconfig"
KBUILD_DEFCONFIG:raspberrypi-cm3 ?= "bcm2709_defconfig"
KBUILD_DEFCONFIG:raspberrypi2 ?= "bcm2709_defconfig"
KBUILD_DEFCONFIG:raspberrypi3 ?= "bcm2709_defconfig"
KBUILD_DEFCONFIG:raspberrypi3-64 ?= "bcmrpi3_defconfig"
KBUILD_DEFCONFIG:raspberrypi4 ?= "bcm2711_defconfig"
KBUILD_DEFCONFIG:raspberrypi4-64 ?= "bcm2711_defconfig"
LINUX_VERSION_EXTENSION ?= ""
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains("MACHINE_FEATURES", "pitft28r", "stmpe-ts", "", d)}"
# A LOADADDR is needed when building a uImage format kernel. This value is not
# set by default in rpi-4.8.y and later branches so we need to provide it
# manually. This value unused if KERNEL_IMAGETYPE is not uImage.
KERNEL_EXTRA_ARGS += "LOADADDR=0x00008000"

KERNEL_DTC_FLAGS += "-@ -H epapr"