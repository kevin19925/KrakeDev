import { StatusBar } from "expo-status-bar";
import { Button, StyleSheet, Text, View, Alert } from "react-native";
import { useState } from "react";
export default function App() {
  //----------hucks
  /*
  const areglo = useState(0);
  // variable de estado
  const contadorEstado = areglo[0];
  // funcion para modificar y repintar
  const setContadorEtado = areglo[1];*/
  // variable estado para que cambie en pantalla
  const [contadorEstado, setContadorEtado] = useState(0);

  const [vidas, setVidas] = useState(5);
  // variable de estado para rempitar
  const incrementar = () => {
    /*
    contador = contador + 1;
    console.log("contador>>" + contador);*/

    setContadorEtado(contadorEstado + 1);
    console.log("conatdor estado >" + contadorEstado);
  };

  const decrementar = () => {
    setContadorEtado(contadorEstado - 1);
    //console.log("decrementar>>" + contadorEstado);
  };

  const restaVida = () => {
    if (vidas == 0) {
      Alert.alert("advertencia", "GAME OVER");
    } else {
      setVidas(vidas - 1);
    }
  };
  const sumarVidas = () => {
    setVidas(vidas + 3);
  };
  return (
    <View style={styles.container}>
      <Text>vida: {vidas} </Text>
      <Button title="PERDER VIDA" onPress={restaVida} />
      <Button title="Premiar" onPress={sumarVidas} />
      
      {/* <Text>Contador : {contador}</Text> */}
      {/* <Text>Contador estado: {contadorEstado}</Text>
      <Button title="incrementar" onPress={incrementar} />
      <Button title="decrementar" onPress={decrementar} /> */}
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
