import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View, FlatList } from "react-native";

export default function App() {
  const productos = [
    {
      nombre: "Doritos",
      categoria: "Snacks",
      precioCompra: 0.4,
      precioVenta: 0.45,
      id: 100,
    },
    {
      nombre: "Manicho",
      categoria: "Golosinas",
      precioCompra: 0.2,
      precioVenta: 0.25,
      id: 101,
    },
    {
      nombre: "Coca-Cola",
      categoria: "Bebidas",
      precioCompra: 0.6,
      precioVenta: 0.75,
      id: 102,
    },
    {
      nombre: "Samsung Galaxy Buds",
      categoria: "Electrónicos",
      precioCompra: 50,
      precioVenta: 70,
      id: 103,
    },
    {
      nombre: "Camiseta Adidas",
      categoria: "Ropa",
      precioCompra: 10,
      precioVenta: 15,
      id: 104,
    },
  ];

  return (
    <View style={styles.container}>
      <View style={styles.titulo}>
        <Text style={styles.tituloText}> PRODUCTOS</Text>
      </View>
      <View style={styles.flatList}>
        <FlatList
          data={productos}
          renderItem={(producto) => {
            return (
              <View style={styles.lista}>
                <Text>
                  {producto.item.nombre} ({producto.item.categoria})
                </Text>
                <Text style={styles.precio}>
                  USD {producto.item.precioVenta}
                </Text>
              </View>
            );
          }}
          keyExtractor={(item) => {
            item.id;
          }}
        ></FlatList>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
  },

  titulo: {
    flex: 1,
    // backgroundColor: "blue",
    flexDirection: "colum",
    justifyContent: "flex-end",
    alignItems: "center",
  },
  tituloText: {
    fontStyle: "italic",
    fontSize: 20,
    fontWeight: "bold",
  },
  flatList: {
    flex: 6,
  },
  lista: {
    borderColor: "black",
    borderWidth: 2,
    borderRadius: 5,
    margin: 5,
    padding: 10,
    backgroundColor: "#D8F9E7",
  },
  precio: {
    fontSize: 15,
    fontWeight: "bold",
  },
});
