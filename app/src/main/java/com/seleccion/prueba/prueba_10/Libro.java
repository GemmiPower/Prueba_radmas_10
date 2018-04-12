package com.seleccion.prueba.prueba_10;

/**
 * Created by Gemma on 12/04/2018.
 */

public class Libro {
        private String titulo;
        private String editorial;
        private int paginas;

        public Libro(String titulo, String editorial, int paginas) {
            this.titulo = titulo;
            this.editorial = editorial;
            this.paginas = paginas;
        }
        public String getTitulo() {
            return titulo;
        }
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        public String getEditorial() {
            return editorial;
        }
        public void setEditorial(String editorial) {
            this.editorial = editorial;
        }
        public int getPaginas() {
            return paginas;
        }
        public void setPaginas(int paginas) {
            this.paginas = paginas;
        }

}
