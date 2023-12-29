import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import {
  StyleSheet,
  Text,
  View,
  FlatList,
  TextInput,
  Button,
  ScrollView,
} from "react-native";
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
];
let esNuevo = true;
let indiceSeleccionado = -1;

export default function App() {
  const [txtNombre, setTxtNombre] = useState("");
  const [txtCategoria, setTxtCategoria] = useState("");
  const [txtPrecioCompra, setPrecioCompra] = useState("");
  const [txtPrecioVenta, setPrecioVenta] = useState("");
  const [txtId, setId] = useState("");
  const [numElemetos, setnumElementos] = useState(productos.length);

  limpiar = () => {
    setTxtNombre("");
    setTxtCategoria("");
    setPrecioCompra("");
    setPrecioVenta("");
    setId("");
    esNuevo = true;
  };

  let ItemsProducto = (props) => {
    return (
      <View style={styles.itemProducto}>
        <View style={styles.itemIndice}>
          <Text style={styles.textoPrincipal}>{props.producto.id}</Text>
        </View>

        <View style={styles.itemContenido}>
          <Text style={styles.textoPrincipal}>{props.producto.nombre}</Text>
          <Text style={styles.textoSecundario}>{props.producto.categoria}</Text>
        </View>
        <View style={styles.itemPrecio}>
          <Text style={styles.txtPrecio}>{props.producto.precioVenta}</Text>
        </View>
        <View style={styles.itemBotones}>
          <Button
            title="E"
            color="green"
            onPress={() => {
              setId(props.producto.id + "");
              setTxtNombre(props.producto.nombre);
              setTxtCategoria(props.producto.categoria + "");
              setPrecioCompra(props.producto.precioCompra + "");
              setPrecioVenta(props.producto.precioVenta + "");

              indiceSeleccionado = props.indice;
              esNuevo = false;
            }}
          ></Button>
          <Button
            title="X"
            color="red"
            onPress={() => {
              indiceSeleccionado = props.indice;
              productos.splice(indiceSeleccionado, 1);
              setnumElementos(productos.length);
              //console.log(indiceSeleccionado);
            }}
          ></Button>
        </View>
      </View>
    );
  };

  let existeProducto = () => {
    for (let index = 0; index < productos.length; index++) {
      if (productos[index].id == txtId) {
        return true;
      }
    }

    return false;
  };

  let guardarProducto = () => {
    if (
      txtNombre.trim() === "" ||
      txtCategoria.trim() === "" ||
      txtPrecioCompra.trim() === "" ||
      txtPrecioVenta.trim() === "" ||
      txtId.trim() === ""
    ) {
      alert("Todos los campos deben completarse antes de guardar.");
      return; // Detener la función si algún campo está vacío
    }

    if (esNuevo == true) {
      if (existeProducto() == true) {
        alert("ya existe");
      } else {
        let producto = {
          nombre: txtNombre,
          categoria: txtCategoria,
          precioCompra: txtPrecioCompra,
          precioVenta: txtPrecioVenta,
          id: txtId,
        };
        productos.push(producto);
      }
    } else {
      productos[indiceSeleccionado].categoria = txtCategoria;
      productos[indiceSeleccionado].nombre = txtNombre;
      productos[indiceSeleccionado].precioVenta = txtPrecioVenta;
      productos[indiceSeleccionado].precioCompra = txtPrecioCompra;
    }
    limpiar();
    setnumElementos(productos.length);
  };

  return (
    <ScrollView contentContainerStyle={styles.scroll}>
      <View style={styles.container}>
        <View style={styles.titulo}>
          <Text style={styles.txtTitulo}>PRODUCTOS</Text>
        </View>
        <View style={styles.cabecera}>
          <TextInput
            style={styles.cajatexto}
            value={txtId}
            placeholder="CODIGO"
            onChangeText={setId}
            keyboardType="numeric"
            editable={esNuevo}
          ></TextInput>

          <TextInput
            style={styles.cajatexto}
            value={txtNombre}
            placeholder="NOMBRE"
            onChangeText={setTxtNombre}
          ></TextInput>

          <TextInput
            style={styles.cajatexto}
            value={txtCategoria}
            placeholder="CATEGORIA"
            onChangeText={setTxtCategoria}
          ></TextInput>
          <TextInput
            style={styles.cajatexto}
            value={txtPrecioCompra}
            placeholder="PRECIO COMPRA"
            keyboardType="numeric"
            onChangeText={(txt) => {
              setPrecioCompra(txt);

              let costo = parseFloat(txt) * 1.2;
              setPrecioVenta(costo.toFixed(2) + "");
            }}
          ></TextInput>

          <TextInput
            style={styles.cajatexto}
            value={txtPrecioVenta}
            placeholder="PRECIOS VENTA"
            editable={false}
          ></TextInput>

          <View style={styles.areaBotones}>
            <Button title="guardar" onPress={guardarProducto}></Button>
            <Button title="nuevo" onPress={limpiar}></Button>
            <Text> Productos :{numElemetos}</Text>
          </View>
        </View>

        <View style={styles.contenido}>
          <FlatList
            style={styles.lista}
            data={productos}
            renderItem={(obj) => {
              return <ItemsProducto indice={obj.index} producto={obj.item} />;
            }}
            keyExtractor={(item) => {
              return item.id;
            }}
          ></FlatList>
        </View>
        <View style={styles.pie}>
          <Text>AUTOR: kevin quishpe</Text>
        </View>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  scroll: {
    flexGrow: 1,
    backgroundColor: "#F5F5F5",
  },
  container: {
    flex: 1,
    paddingTop: 50,
    // backgroundColor: "#E0AAEC",
    flexDirection: "column",
    justifyContent: "flex-start",
    alignItems: "stretch",
  },
  lista: {
    //  backgroundColor: "#F5B261",
  },
  itemProducto: {
    flex: 1,
    flexDirection: "row",
    //backgroundColor: "#61F5A2",
    marginBottom: 10,
    padding: 10,
    borderColor: "black",
    borderWidth: 2,
    borderRadius: 10,
    margin: 10,
  },
  textoPrincipal: {
    fontSize: 20,
  },
  textoSecundario: {
    fontStyle: "italic",
    fontSize: 16,
  },
  cabecera: {
    flex: 4,
    //backgroundColor: "#E5EA98",
  },
  contenido: {
    flex: 6,
    // backgroundColor: "#98EAD4",
  },
  pie: {
    flex: 1,
    backgroundColor: "#EA98E7",
    justifyContent: "center",
    alignItems: "flex-end",
    paddingRight: 30,
  },
  itemIndice: {
    //backgroundColor: "#E0F7F0",
    flex: 2,
    justifyContent: "center",
    alignItems: "center",
  },
  itemContenido: {
    //backgroundColor: "#E9D9FA",
    flex: 6,
    paddingLeft: 10,
  },
  itemBotones: {
    flex: 3,
    //backgroundColor: "#F5FAD9",
    flexDirection: "row",
    justifyContent: "space-evenly",
    alignItems: "center",
  },
  itemPrecio: {
    flex: 2,
    justifyContent: "center",
    alignItems: "flex-start",
  },

  txtPrecio: {
    fontSize: 17,
    fontWeight: "bold",
  },
  cajatexto: {
    borderColor: "gray",
    borderWidth: 2,
    margin: 5,
    paddingLeft: 10,
    fontSize: 18,
  },
  areaBotones: {
    flex: 1,
    flexDirection: "row",
    justifyContent: "space-evenly",
    alignItems: "center",
  },
  titulo: {
    flex: 1,
    // backgroundColor: "blue",
    flexDirection: "colum",
    justifyContent: "flex-end",
    alignItems: "flex-start",
    margin: 10,
  },
  txtTitulo: {
    fontSize: 20,
    fontStyle: "italic",
    fontWeight: "bold",
  },
});
