SUMMARY = "A console-only image that fully supports the target device \
hardware."
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES:append = "\
	ssh-server-openssh \
"

#IMAGE_FEATURES:append = "\
#	package-management \
#"

IMAGE_INSTALL:append = "\
	librespot \
	librespot-user \
"
inherit extrausers
# how to
# pw: librespot
# at bash: usermod -p $(openssl passwd librespot) root
# get a salted hash: openssl passwd librespot
# one possible result: lWIufFD0N1Jvs
# the command now looks: usermod -p lWIufFD0N1Jvs root

EXTRA_USERS_PARAMS = "usermod -p lWIufFD0N1Jvs root;"