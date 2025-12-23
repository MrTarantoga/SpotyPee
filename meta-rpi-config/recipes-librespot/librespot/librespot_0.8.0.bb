inherit cargo_bin

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get librespot could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/librespot/v0.8.0"
SRC_URI += "git://github.com/librespot-org/librespot.git;protocol=https;nobranch=1"
SRCREV = "d36f9f1907e8cc9d68a93f8ebc6b627b1bf7267d"

S = "${WORKDIR}/git"

CARGO_SRC_DIR = ""
CARGO_BUILD_FLAGS:append = " --no-default-features --features rustls-tls-native-roots --features with-libmdns --features pulseaudio-backend"

DEPENDS = "\
    pulseaudio \
    avahi-libnss-mdns \
    virtual/libc \
"
RDEPENDS:${PN} = "\
    pulseaudio \
    avahi-libnss-mdns \
    ca-certificates \
"

export BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${STAGING_DIR_TARGET}"
do_compile[exported_vars] += "BINDGEN_EXTRA_CLANG_ARGS"
do_compile[network] = "1"

# FIXME: update generateme with the real MD5 of the license file
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=98b2b0c9a6081259c441045ca68b640f \
"

SUMMARY = "An open source client library for Spotify, with support for Spotify Connect"
HOMEPAGE = "https://github.com/librespot-org/librespot"
LICENSE = "MIT"
