import {
  View,
  Text,
  StyleSheet,
  FlatList,
  TouchableHighlight,
} from "react-native";
import { Button, ListItem, FAB } from "@rneui/base";
import { getAllConstac } from "../rest_cliente/contact";
import { useState, useEffect } from "react";

export const ListaContactos = ({ navigation }) => {
  const [contactList, setContactList] = useState([]);

  fnRefreshList = (contactos) => {
    setContactList(contactos);
  };

  useEffect(() => {
    console.log("usess");
    getAllConstac(fnRefreshList);
  }, []);
  const ContactItem = ({ contact }) => {
    // obtengo las prpiedades
    return (
      <TouchableHighlight
        onPress={() => {
          navigation.navigate("ContactsForm", { objContact: contact });
        }}
      >
        <ListItem>
          <ListItem.Content>
            <ListItem.Title>
              {contact.nombre} {contact.apellido}
            </ListItem.Title>
            <ListItem.Subtitle>{contact.celular}</ListItem.Subtitle>
          </ListItem.Content>
        </ListItem>
      </TouchableHighlight>
    );
  };

  // flatList es como hacer un foreach
  return (
    <View style={styles.container}>
      <Text>Lista contactos</Text>

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
          navigation.navigate("ContactsForm",{});
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
