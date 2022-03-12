DEPENDS += "sed-native"

do_deploy:append() {

	# Remove overscan (no display)
	sed -i '/# have a properly sized image/d' $CONFIG
	sed -i '/disable_overscan=1/d' $CONFIG
	sed -i '/# Enable audio (loads snd_bcm2835)/d' $CONFIG

	# Remove RPi Audio
	sed -i '/dtparam=audio=on/d' $CONFIG
}
