import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import {
  StyleSheet,
  Text,
  View,
  FlatList,
  TextInput,
  Button,
} from "react-native";
const personas = [
  { nombre: "Juan", apellido: "Gómez", cedula: "1234567890" },
  { nombre: "María", apellido: "Rodríguez", cedula: "2345678901" },
  { nombre: "Carlos", apellido: "López", cedula: "3456789012" },
  { nombre: "Laura", apellido: "Martínez", cedula: "4567890123" },
  { nombre: "Pedro", apellido: "González", cedula: "5678901234" },
];
let esNuevo = true;
let indiceSeleccionado = -1;
export default function App() {
  const [txtNombre, setTxtNombre] = useState("");
  const [txtApellido, setTxtApellido] = useState("");
  const [txtCedula, setTxtCedula] = useState("");
  const [numElemetos, setElementos] = useState(personas.length);
  limpiar = () => {
    setTxtNombre();
    setTxtApellido();
    setTxtCedula();
    esNuevo = true;
  };

  // --- creacion de elementos
  // funcion que recibe un propiedes  y retorna un jsx
  // let ItemsPersona = (props) => {
  //   return (
  //     <View >
  //     {props.indice}
  //     {props.persona.nombre}
  //     </View>
  //   );
  // };

  // pero desde render debes mandar esas propiedades

  // renderItem={(obj) => {
  //   return <ItemsPersona indice={obj.index} persona={obj.item} />;
  // }}
  let ItemsPersona = (props) => {
    return (
      <View style={styles.itempersona}>
        <View style={styles.itemIndice}>
          <Text style={styles.textoPrincipal}>{props.indice}</Text>
        </View>

        <View style={styles.itemContenido}>
          <Text style={styles.textoPrincipal}>
            {props.persona.nombre} {props.persona.apellido}
          </Text>
          <Text style={styles.textoSecundario}> {props.persona.cedula}</Text>
        </View>
        <View style={styles.itemBotones}>
          <Button
            title="E"
            color="green"
            onPress={() => {
              setTxtApellido(props.persona.apellido);
              setTxtNombre(props.persona.nombre);
              setTxtCedula(props.persona.cedula);
              indiceSeleccionado = props.indice;
              esNuevo = false;
            }}
          ></Button>
          <Button
            title="X"
            color="red"
            onPress={() => {
              indiceSeleccionado = props.indice;
              //eliminar
              personas.splice(indiceSeleccionado, 1);
              setElementos(personas.length);
              numElemetos;
            }}
          ></Button>
        </View>
      </View>
    );
  };

  let existePersona = () => {
    for (let index = 0; index < personas.length; index++) {
      if (personas[index].cedula == txtCedula) {
        //console.log(personas[index].cedula + " " + txtCedula);
        return true;
      }
    }

    return false;
  };

  let guardarPersona = () => {
    if (esNuevo == true) {
      if (existePersona() == true) {
        alert("ya existe");
      } else {
        let persona = {
          nombre: txtNombre,
          apellido: txtApellido,
          cedula: txtCedula,
        };
        personas.push(persona);
      }
    } else {
      personas[indiceSeleccionado].nombre = txtNombre;
      personas[indiceSeleccionado].apellido = txtApellido;
    }
    limpiar();
  };

  return (
    <View style={styles.container}>
      <View style={styles.cabecera}>
        <Text>ejemplo lista</Text>
        <TextInput
          style={styles.cajatexto}
          value={txtCedula}
          placeholder="Ingrese cedula"
          onChangeText={setTxtCedula}
          keyboardType="numeric"
          editable={esNuevo}
        ></TextInput>
        <TextInput
          style={styles.cajatexto}
          value={txtNombre}
          placeholder="Ingrese nombre"
          onChangeText={setTxtNombre}
        ></TextInput>
        <TextInput
          style={styles.cajatexto}
          value={txtApellido}
          placeholder="Ingrese apellido"
          onChangeText={setTxtApellido}
        ></TextInput>
        <View style={styles.areaBotones}>
          <Button title="guardar" onPress={guardarPersona}></Button>
          <Button title="nuevo" onPress={limpiar}></Button>
        </View>
      </View>
      {/* maneja listas 
       -------data :areglo del objetos , la lista
      ------renderItem= funcion para pintar los elementos ,funcion de retorna en jsx y pinta  ,recibe un obj ,, parecedo a un foreach
      renderItem={(obj)=>{return <text> elemento de la lista </text>}}
      obj tiene atributos 
      item:objeto
      index:indice 
      section
      separator
      -------keyExtractor :retorna clave unica , importante
      keyExtractor=(item)=>{
        return item.cedula
      }
      
      */}
      <View style={styles.contenido}>
        <FlatList
          style={styles.lista}
          data={personas}
          renderItem={(obj) => {
            return <ItemsPersona indice={obj.index} persona={obj.item} />;
          }}
          keyExtractor={(item) => {
            return item.cedula;
          }}
        ></FlatList>
      </View>
      <View style={styles.pie}>
        <Text>AUTOR: kevin quishpe</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 50,
    backgroundColor: "#E0AAEC",
    flexDirection: "column",
    justifyContent: "flex-start",
    alignItems: "stretch",
  },
  lista: {
    backgroundColor: "#F5B261",
  },
  itempersona: {
    flex: 1,
    flexDirection: "row",
    backgroundColor: "#61F5A2",
    marginBottom: 10,
    padding: 10,
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
    backgroundColor: "#E5EA98",
  },
  contenido: {
    flex: 6,
    backgroundColor: "#98EAD4",
  },
  pie: {
    flex: 1,
    backgroundColor: "#EA98E7",
    justifyContent: "center",
    alignItems: "flex-end",
    paddingRight: 30,
  },
  itemIndice: {
    backgroundColor: "#E0F7F0",
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  itemContenido: {
    backgroundColor: "#E9D9FA",
    flex: 6,
    paddingLeft: 10,
  },
  itemBotones: {
    flex: 2,
    backgroundColor: "#F5FAD9",
    flexDirection: "row",
    justifyContent: "space-evenly",
    alignItems: "center",
  },
  cajatexto: {
    borderColor: "gray",
    borderWidth: 2,
    margin: 5,
    paddingLeft: 10,
  },
  areaBotones: {
    flex: 1,
    flexDirection: "row",
    justifyContent: "space-evenly",
    alignItems: "center",
  },
});
