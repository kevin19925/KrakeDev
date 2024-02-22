import { Alert, StyleSheet, Text, View } from "react-native";
import { Button, ListItem } from "@rneui/base";
import { useState } from "react";
import { saveRest } from "../rest_Laptops/Laptops";
import { Input } from "@rneui/themed";

export const Ingreso = ({ navigation }) => {
  const [marca, setMarca] = useState("");
  const [procesador, setProcesador] = useState("");
  const [memoria, setMemoria] = useState("");

  const save = () => {
    saveRest(
      { marca: marca, procesador: procesador, memoria: memoria },
      mostrarAlert
    );
  };

  const mostrarAlert = () => {
    Alert.alert(
      "Título del Alerta",
      "ingreso correcto",
      [
        {
          text: "OK",
          onPress: () => {
            console.log("OK Presionado");
            navigation.goBack();
          },
        },
        {
          text: "Cancelar",
          onPress: () => console.log("Cancelar Presionado"),
          style: "cancel", // Estilo de botón de cancelar
        },
      ],
      { cancelable: false }
    );
  };

  return (
    <View style={styles.container}>
      <Input
        placeholder="marca:"
        value={marca}
        onChangeText={(text) => {
          setMarca(text);
        }}
      ></Input>
      <Input
        placeholder="procesador: "
        value={procesador}
        onChangeText={(text) => {
          setProcesador(text);
        }}
      ></Input>
      <Input
        placeholder="memoria:"
        value={memoria}
        onChangeText={(text) => {
          setMemoria(text);
        }}
      ></Input>
      <Button
        title="GUARDAR"
        onPress={
          //mostrarAlert();
          save
        }
      ></Button>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    flexDirection: "column", // eje pricipal es vertical
    justifyContent: "center",
    alignItems: "stretch", // orisontal
  },
});
