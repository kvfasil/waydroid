SUMMARY = "Waydroid implementation on RDK stack"

LICENSE = "CLOSED"

PV = "1.1.28"

SRC_URI = "https://github.com/mer-hybris/libgbinder/archive/refs/tags/${PV}.zip;protocol=http"
SRC_URI[sha256sum] = "d3d3408c53451fc5fe58d8d96bce0b0277222fc363dc3f77b540f835abe0386b"

#GLIBUTIL_PATH="${PKG_CONFIG_PATH}"
#export PKG_CONFIG_PATH=${PKG_CONFIG_PATH}:/home/fkv900/rpi/build-raspberrypi-rdk-mc/tmp/work/cortexa7t2hf-neon-vfpv4-rdk-linux-gnueabi/libglibutil/1.0.67-r0/libglibutil-1.0.67/build:"

export PKG_CONFIG_PATH="/home/fkv900/rpi/build-raspberrypi-rdk-mc/tmp/work/cortexa7t2hf-neon-vfpv4-rdk-linux-gnueabi/libgbinder/1.1.28-r0/recipe-sysroot/usr/lib/pkgconfig:/home/fkv900/rpi/build-raspberrypi-rdk-mc/tmp/work/cortexa7t2hf-neon-vfpv4-rdk-linux-gnueabi/libgbinder/1.1.28-r0/recipe-sysroot/usr/share/pkgconfig:/home/fkv900/rpi/build-raspberrypi-rdk-mc/tmp/work/cortexa7t2hf-neon-vfpv4-rdk-linux-gnueabi/libglibutil/1.0.67-r0/libglibutil-1.0.67/build:"

export PKG_CONFIG_SYSTEM_INCLUDE_PATH="/usr/include:/home/fkv900/rpi/build-raspberrypi-rdk-mc/tmp/work/cortexa7t2hf-neon-vfpv4-rdk-linux-gnueabi/libglibutil/1.0.67-r0/libglibutil-1.0.67/include:"

S = "${WORKDIR}/${PN}-${PV}"
DEPENDS = "glib-2.0 libglibutil"

inherit base pkgconfig
do_configure () {
     # Specify any needed configure commands here
     :
}

do_compile () {
     # You will almost certainly need to add additional arguments here
     oe_runmake
}

do_install () {
         oe_runmake install-dev DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} INCLUDEDIR=${includedir}
}

