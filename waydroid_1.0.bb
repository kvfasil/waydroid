SUMMARY = "Waydroid implementation on RDK stack"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PV="1.2.1"

#SRC_URI = "https://github.com/waydroid/waydroid/archive/refs/tags/1.2.1.zip;protocol=http"
SRC_URI = "https://github.com/waydroid/waydroid/archive/refs/tags/${PV}.zip;protocol=http"

SRC_URI[md5sum] = "4efcca75f63421af37a504512e262be6"
SRC_URI[sha256sum] = "f64f2b8914fe83885901588feb53695b994d762531f7fe6b990d7c12118cd574"

S = "${WORKDIR}/${PN}-${PV}"

#do_compile () {
#	#add if anything need to compile
#}

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${libdir}	
	install -d ${D}${sysconfdir}	
	install -d ${D}${libdir}/waydroid
	install -d ${D}${systemd_unitdir}/system
	
	install -m 0755 ${S}/waydroid.py ${D}${libdir}/waydroid/
	install -m 0755 ${S}/gbinder/anbox.conf ${D}${sysconfdir}/gbinder.d
	
	cp -r ${S}/tools/* ${D}${libdir}/waydroid/
	cp -r ${S}/data/* ${D}${libdir}/waydroid/
	chmod -R 755 ${D}${libdir}/waydroid/

	ln -s -r ${D}${libdir}/waydroid/waydroid.py ${D}${bindir}/waydroid
	install -m 0644 ${S}/debian/waydroid-container.service ${D}${systemd_unitdir}/system/waydroid-container.service
	
}

#FILES_${PN} = "${bindir}/helloYocto ${bindir}/zlibtest "
