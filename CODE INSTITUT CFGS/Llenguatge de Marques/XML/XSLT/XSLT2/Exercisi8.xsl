<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <h1>Mis peliculas clasicas preferidas</h1>
            <li>
                <xsl:for-each select="//pelicula">
                    <ul>
                        <span style="color:#FF0000">
                            <p> Pelicula: <xsl:value-of select="titulo" />
                            </p>
                        </span>
                        <span style="color:#00FF00">
                            <p> Director: <xsl:value-of select="direccion" />
                            </p>
                        </span>
                    </ul>
                </xsl:for-each>
            </li>
        </html>
    </xsl:template>
</xsl:stylesheet>