import { View, Text, StyleSheet, FlatList, Alert } from "react-native";
import { Button, ListItem, Input } from "@rneui/base";
import { useState } from "react";
import { saveContactRest } from "../rest_cliente/contact";
export const ContactForm = ({ navigation }) => {
  const [nombre, setNombre] = useState();
  const [apellido, setApellido] = useState();
  const [telefono, setTelefono] = useState();

  const saveContact = () => {
    saveContactRest(
      { nom: nombre, ape: apellido, tele: telefono },
      showMessage
    );
  };

  const showMessage = () => {
    Alert.alert(
      "Título del Alerta",
      "Mensaje del Alerta",
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
        value={nombre}
        placeholder="NOMBRE"
        onChangeText={(value) => {
          setNombre(value);
        }}
      ></Input>
      <Input
        value={apellido}
        placeholder="Apellido"
        onChangeText={(value) => {
          setApellido(value);
        }}
      ></Input>
      <Input
        value={telefono}
        placeholder="TELEFONO"
        onChangeText={(value) => {
          setTelefono(value);
        }}
      ></Input>

      <Button title="GUARDRA" onPress={saveContact}></Button>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
