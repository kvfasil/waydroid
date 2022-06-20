SUMMARY = "Python GObject bindings"
HOMEPAGE = "https://gitlab.gnome.org/GNOME/pygobject"
DESCRIPTION = "PyGObject is a Python package which provides bindings for GObject based libraries such as GTK, GStreamer, WebKitGTK, GLib, GIO and many more."
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a916467b91076e631dd8edb7424769c7"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase distutils3-base gobject-introspection upstream-version-is-even

DEPENDS += "python3 glib-2.0"

SRCNAME="pygobject"

SRC_URI = " \
    http://ftp.gnome.org/pub/GNOME/sources/${SRCNAME}/${@gnome_verdir("${PV}")}/${SRCNAME}-${PV}.tar.xz \
    file://0001-Do-not-build-tests.patch \
    file://libcairo-gobject.so.2 \
"
SRC_URI[md5sum] = "ca1dc4f31c1d6d283758e8f315a88ab6"
SRC_URI[sha256sum] = "87e2c9aa785f352ef111dcc5f63df9b85cf6e05e52ff04f803ffbebdacf5271a"

UNKNOWN_CONFIGURE_WHITELIST = "introspection"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit pypi setuptools3

do_install () {

install -d ${D}/usr/lib/python3.8/site-packages/gi/


install -m 0655 ${S}/../libcairo-gobject.so.2 ${D}/usr/lib/python3.8/site-packages/gi/

}


PACKAGECONFIG ??= "${@bb.utils.contains_any('DISTRO_FEATURES', [ 'directfb', 'wayland', 'x11' ], 'cairo', '', d)}"



RDEPENDS_${PN} += "python3-pkgutil"
#RDEPENDS_${PN} = "libcairo-gobject"

# python3-pycairo is checked on configuration -> DEPENDS
# we don't link against python3-pycairo -> RDEPENDS
PACKAGECONFIG[cairo] = "-Dpycairo=true,-Dpycairo=false, cairo python3-pycairo, python3-pycairo"

#PACKAGECONFIG[cairo] = "-Dpycairo=true,-Dpycairo=false,cairo python3-pycairo"
FILES_${PN} = LASSEXTEND

BBCLASSEXTEND = "native"
PACKAGECONFIG_class-native = ""

#note
