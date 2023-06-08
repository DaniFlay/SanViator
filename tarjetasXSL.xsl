<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output method="xml" indent="yes"/>
	<xsl:template match="profesores">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="Card" page-height="55mm" page-width="85mm" margin-top="1mm" margin-bottom="1mm" margin-left="3mm" margin-right="2mm">
					<fo:region-body margin-top="1mm"/>
					<fo:region-before extent="3mm"/>
					<fo:region-after extent="1.5mm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<xsl:for-each select="profesor">
				<fo:page-sequence master-reference="Card">
					<fo:flow flow-name="xsl-region-body">
						<fo:table>
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell  padding-left="0.5mm">
										<fo:block font-size="3mm" padding-top="8mm" font-family="Brush Script MT, cursive">
											<xsl:value-of select="nombre"/>
										</fo:block>
										<fo:block font-size="2mm" font-family="Monaco, monospace">
											<xsl:value-of select="ocupacion"/>
										</fo:block>
										<fo:block>
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\horizontal.png)" content-width="7.5mm"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block margin-left="18mm" margin-top="5mm">
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\logoSanViator.png)" content-width="15mm"/>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:table width="35mm">
							<fo:table-body font-family="Lucida Console, monospace">
								<fo:table-row>
									<fo:table-cell width="4mm">
										<fo:block font-size="1.5mm" margin-top="0.35mm">
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\telefono.png)" content-height="3.5mm"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="1mm" margin-left="0.6mm" >
										<fo:block>
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\verticalAzul.png)" content-height="3.5mm"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="25mm">
										<fo:block font-size="1.5mm" margin-left="1.8mm" margin-top="0.6mm">
											<xsl:value-of select="telefono[@tipo='fijo']"/>
											</fo:block>
											<fo:block font-size="1.5mm" margin-left="1.8mm"> 
											<xsl:value-of select="telefono[@tipo='movil']"/>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell width="4mm">
										<fo:block font-size="1.5mm" margin-top="0.35mm">
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\correo.png)" content-height="3.5mm"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="1mm" margin-left="0.6mm" >
										<fo:block>
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\verticalNegra.png)" content-height="3.5mm"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="25mm">
										<fo:block font-size="1.5mm" margin-left="1.8mm" margin-top="0.6mm">
											<xsl:value-of select="correo"/>
											</fo:block>
											<fo:block font-size="1.5mm" margin-left="1.8mm"> 
											<xsl:value-of select="web"/>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell width="4mm">
										<fo:block font-size="1.5mm" margin-top="0.35mm">
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\direccion.png)" content-height="3.5mm"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="1mm" margin-left="0.6mm" >
										<fo:block>
											<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Desktop\iconos\verticalAzul.png)" content-height="3.5mm"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="25mm">
										<fo:block font-size="1.5mm" margin-left="1.8mm" margin-top="0.6mm">
											<xsl:value-of select="direccion"/>
											</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:flow>
				</fo:page-sequence>
			</xsl:for-each>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>