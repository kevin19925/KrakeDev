import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import { StyleSheet, Text, View, TextInput, Button } from "react-native";

export default function App() {
  [dolar, setdolar] = useState("0");
  [resultado, setresultado] = useState("0");
  [nombre, setnombre] = useState("");
  pesos_mexicanos = () => {
    let dolares = parseInt(dolar);
    setresultado(dolares * 16.91);
    setnombre("PESOS MEXICANOS");
  };
  pesos_colombianos = () => {
    setresultado(parseInt(dolar) * 3871.45);
    setnombre("PESOS COLOMBIANOS");
  };
  euros = () => {
    setresultado(parseInt(dolar) * 0.83);
    setnombre("EUROS");
  };
  return (
    <View style={styles.container}>
      <Text>ingrese dolares!</Text>
      <TextInput
        style={styles.caja}
        value={dolar}
        onChangeText={(txt) => {
          setdolar(txt);
        }}
      ></TextInput>
      <Button title="PESOS MEXICANOS" onPress={pesos_mexicanos}></Button>
      <Button title="PESOS COLOMBIANOS" onPress={pesos_colombianos}></Button>
      <Button title=" EUROS" onPress={euros}></Button>
      <Text>{resultado + " " + nombre}</Text>

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
  caja: {
    borderColor: "Black",
    borderWidth: 1,
    padding: 10,
  },
});
