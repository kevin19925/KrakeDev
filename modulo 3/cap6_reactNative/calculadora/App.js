import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import { StyleSheet, Text, View, Button, TextInput } from "react-native";

export default function App() {
  const [num1, setNum1] = useState("0");
  const [num2, setNum2] = useState("0");
  const [result, setResult] = useState(0);

  sumar = () => {
    let n1 = parseFloat(num1);
    let n2 = parseFloat(num2);
    setResult(n1 + n2);
  };

  restar = () => {
    let n1 = parseFloat(num1);
    let n2 = parseFloat(num2);
    setResult(n1 - n2);
  };

  multiplicar = () => {
    let n1 = parseFloat(num1);
    let n2 = parseFloat(num2);
    setResult(n1 * n2);
  };

  return (
    <View style={styles.container}>
      <Text>calculadora</Text>
      <TextInput
        style={styles.caja}
        value={num1}
        onChangeText={(text) => {
          setNum1(text);
        }}
      ></TextInput>
      <TextInput
        style={styles.caja}
        value={num2}
        onChangeText={(text) => {
          setNum2(text);
        }}
      ></TextInput>
      <Button title="sumar" onPress={sumar}></Button>
      <Button title="restar" onPress={restar}></Button>
      <Button title="multiplicar" onPress={multiplicar}></Button>

      <Text>el resultado es : {result}</Text>
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
