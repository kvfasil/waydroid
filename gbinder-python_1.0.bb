SUMMARY = "Waydroid implementation on RDK stack"

LICENSE = "CLOSED"

PV = "1.1.1"

SRC_URI = "https://github.com/erfanoabdi/gbinder-python/archive/refs/tags/${PV}.zip;protocol=http"

SRC_URI[sha256sum] = "5d0ebdd1dc323aa87e371aff05f7dd7d18777475b99261335d034779ab171f0a"

S = "${WORKDIR}/${PN}-${PV}"
PYTHON_DIR = "python3.8"
DEPENDS          = "python3-native"
RDEPENDS_${PN} = "python python3 python3-pip python3-cython libgbinder libglibutil"


DEPENDS = "python3 python3-cython python3-cython-native libgbinder libglibutil"
RDEPENDS:${PN} = " python3-requests python3-multiprocessing python3-image python3-json "
RRECOMMENDS:${PN} = " python3-pillow "

#inherit pkgconfig lib_package setuptools distutils     #py2 - working solution
inherit pkgconfig lib_package setuptools3       

do_compile () {
     python3 ${S}/setup.py build_ext --inplace
}
