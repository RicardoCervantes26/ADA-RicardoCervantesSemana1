import java.util.*;
public class QuickSort {

    public static void QuicksortEjemplo(List<Integer> lista) {
        // Si la lista es muy pequeña, ya está ordenada
        if (lista.size() <= 1) return;

        // Llamar al metodo recursivo y reemplazar la lista original con la ordenada
        List<Integer> listaOrdenada = ordenar(lista);
        lista.clear();
        lista.addAll(listaOrdenada);
    }

    // Metodo recursivo que implementa la lógica de Ordenación Rápida
    private static List<Integer> ordenar(List<Integer> lista) {
        // Caso base: listas pequeñas ya ordenadas
        if (lista.size() <= 1) return lista;

        // Elegir pivote
        Random generadorAleatorio = new Random();
        int indicePivote = generadorAleatorio.nextInt(lista.size());
        int pivote = lista.get(indicePivote);

        // Crear listas para la partición
        List<Integer> menores = new ArrayList<>();    // Números menores al pivote
        List<Integer> iguales = new ArrayList<>();    // Números iguales al pivote  
        List<Integer> mayores = new ArrayList<>();    // Números mayores al pivote

        // Particionar: dividir números alrededor del pivote
        for (int numero : lista) {
            if (numero < pivote) menores.add(numero);
            else if (numero == pivote) iguales.add(numero);
            else mayores.add(numero);
        }

        // Aplicar ordenación recursiva y unir resultados
        return unirListas(ordenar(menores), iguales, ordenar(mayores));
    }

    // Metodo auxiliar para unir las tres listas
    private static List<Integer> unirListas(List<Integer> lista1, List<Integer> lista2, List<Integer> lista3) {
        List<Integer> resultado = new ArrayList<>();
        resultado.addAll(lista1);  // Agregar números menores
        resultado.addAll(lista2);  // Agregar números iguales  
        resultado.addAll(lista3);  // Agregar números mayores
        return resultado;
    }

    // Metodo de prueba usando solo Listas
    public static void main(String[] args) {
        // Crear lista de números de pedido directamente
        List<Integer> numerosPedido = new ArrayList<>(Arrays.asList(1005, 1002, 1008, 1001, 1006, 1003));

        System.out.println("Pedidos desordenados:");
        System.out.println(numerosPedido);

        // Aplicar ordenación rápida directamente a la lista
        QuicksortEjemplo(numerosPedido);

        System.out.println("Pedidos ordenados:");
        System.out.println(numerosPedido);

        // Ejemplo con más pedidos
        List<Integer> masPedidos = new ArrayList<>();
        masPedidos.add(205);
        masPedidos.add(198);
        masPedidos.add(312);
        masPedidos.add(156);
        masPedidos.add(279);

        System.out.println("\nMás pedidos desordenados:");
        System.out.println(masPedidos);

        QuicksortEjemplo(masPedidos);

        System.out.println("Más pedidos ordenados:");
        System.out.println(masPedidos);
    }

}
