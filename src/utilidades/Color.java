package utilidades;

public enum Color {
    AZUL_100(new java.awt.Color(8, 83, 148)),
    AZUL_70(new java.awt.Color(89, 126, 170)),
    AZUL_60(new java.awt.Color(123, 179, 227)),
    AZUL_50(new java.awt.Color(111, 168, 220)),
    AZUL_40(new java.awt.Color(108, 154, 215)),
    AZUL_30(new java.awt.Color(159, 197, 248)),
    BLACK(new java.awt.Color(0, 0, 0)),
    GRIS_70(new java.awt.Color(110, 110, 110)),
    GRIS_50(new java.awt.Color(153, 153, 153)),
    GRIS_30(new java.awt.Color(180, 180, 180)),
    VERDE_100(new java.awt.Color(39, 78, 19)),
    VERDE_50(new java.awt.Color(106, 168, 79)),
    WHITE(new java.awt.Color(255, 255, 255));

    private final java.awt.Color color;

    private Color(java.awt.Color color) {
        this.color = color;
    }

    public java.awt.Color getColor() {
        return this.color;
    }
}
