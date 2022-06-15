# waydroid
waydroid recipe for yocto build

to add as part of build

WHITELIST_GPL-3.0 += " waydroid"
DISTRO_FEATURES_append = " waydroid"
IMAGE_INSTALL_append = " waydroid"

