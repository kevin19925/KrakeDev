import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import { Button, StyleSheet, Text, TextInput, View } from "react-native";

export default function App() {
  const [texto, settexto] = useState("ingrese nombre");
  const [apellido, setApellido] = useState("ingrese apellido ");
  const [NombreConmpleto, SetNombreCompleto] = useState("");
  return (
    <View style={styles.container}>
      <StatusBar style="auto" />
      <Text>text inpu</Text>
      <TextInput
        style={styles.cajaTexto}
        value={texto}
        onChangeText={(txt) => {
          settexto(txt);
        }}
      />

      <TextInput
        style={styles.cajaTexto}
        value={apellido}
        onChangeText={(texto) => {
          setApellido(texto);
        }}
      />

      <Button
        title="saludar"
        onPress={() => {
          let completo = texto + " " + apellido;
          SetNombreCompleto("hola "+completo);
          alert(completo);
        }}
      />

      <Text>{NombreConmpleto}</Text>
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
  cajaTexto: {
    borderColor: "Black",
    borderWidth: 1,
    padding: 10,
  },
});
