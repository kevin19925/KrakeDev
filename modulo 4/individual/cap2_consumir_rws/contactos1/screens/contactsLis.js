import { View, Text, StyleSheet, FlatList } from "react-native";
import { Button, ListItem, FAB } from "@rneui/base";
import { getAllConstac } from "../rest_cliente/contact";
import { useState } from "react";

export const ListaContactos = ({ navigation }) => {
  const [contactList, setContactList] = useState([]);

  const ContactItem = ({ contact }) => {
    // obtengo las prpiedades
    return (
      <ListItem>
        <ListItem.Content>
          <ListItem.Title>
            {contact.nombre} {contact.apellido}
          </ListItem.Title>
          <ListItem.Subtitle>{contact.celular}</ListItem.Subtitle>
        </ListItem.Content>
      </ListItem>
    );
  };

  fnRefreshList = (contactos) => {
    setContactList(contactos);
  };

  // flatList es como hacer un foreach
  return (
    <View style={styles.container}>
      <Text>Lista contactos</Text>
      <Button
        title="Consultar"
        onPress={() => {
          getAllConstac(fnRefreshList);
        }}
      ></Button>

      <FlatList
        data={contactList}
        renderItem={({ item }) => {
          // deficno propiedad de contact paa mandar a compoente
          return <ContactItem contact={item}></ContactItem>;
        }}
      ></FlatList>

      <FAB
        title="+"
        onPress={() => {
          navigation.navigate("ContactsForm");
        }}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    flexDirection: "column", // eje pricipal es vertical
    justifyContent: "flex-start",
    alignItems: "stretch", // orisontal
  },
});
