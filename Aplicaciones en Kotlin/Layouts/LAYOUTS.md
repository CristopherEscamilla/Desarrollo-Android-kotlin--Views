# Práctica: tres diseños de calculadora

El proyecto está en `Aplicaciones en Kotlin/Layouts`. Abre esa carpeta en Android
Studio como proyecto y sincroniza Gradle. El nombre del proyecto sigue siendo `Layouts`.

Se conserva una sola actividad, `MainActivity`. Esta práctica implementa la interfaz;
los botones todavía no ejecutan operaciones.

| Recurso | Contenedor | Fondos |
| --- | --- | --- |
| `activity_main.xml` | ConstraintLayout, cadenas en ambos ejes | Gris y negro |
| `activity_linear.xml` | LinearLayout, filas y pesos | Azul |
| `activity_grid.xml` | GridLayout, filas/columnas y pesos | Verde |

Cada diseño contiene 16 botones en una matriz de 4 × 4:

```text
7 8 9 ÷
4 5 6 ×
1 2 3 −
0 . = +
```

En vertical, el resultado ocupa el 20% superior y el teclado el 80% inferior.
En horizontal, el resultado ocupa el 20% izquierdo y el teclado el 80% derecho.
La guía de ConstraintLayout está al `0.20`, porque el porcentaje se mide desde
arriba o desde la izquierda; así queda el 80% disponible para el teclado.
LinearLayout y GridLayout usan pesos de 1 y 4 para expresar esa misma proporción.

Los recursos están en `res/layout-port` y `res/layout-land`; `res/layout` contiene
las versiones verticales como recursos predeterminados. Los fondos redondeados
se encuentran en `res/drawable/bg_*.xml`, las cadenas en
`res/values/calculator_strings.xml` y los estilos en `res/values/calculator_styles.xml`.

Para revisar cada diseño en Android Studio, abre su XML en la vista Design.
Para ejecutarlo, cambia el argumento de `setContentView` en `MainActivity` por
`R.layout.activity_main`, `R.layout.activity_linear` o `R.layout.activity_grid`.
Al rotar, Android selecciona la variante correspondiente automáticamente.
