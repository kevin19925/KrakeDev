import {
  FlatList,
  StyleSheet,
  Text,
  View,
  TouchableHighlight,
} from "react-native";
import { Button, ListItem, FAB } from "@rneui/base";
import { useState, useEffect } from "react";
import { getLaptops } from "../rest_Laptops/Laptops";

export const Lista = ({ navigation }) => {
  const [ListaLaptops, setListaLaptops] = useState([]);

  refresList = (contactos) => {
    setListaLaptops(contactos);
  };

  useEffect(() => {
    console.log("usess");
    getLaptops(refresList);
  }, []);
  // como segundo parametro [] para que se ejecute solo un avez
  const ItemLaptops = ({ laptop }) => {
    return (
      <TouchableHighlight
        onPress={() => {
          navigation.navigate("IngresoLaptopsNav", { objLaptop: laptop });
        }}
      >
        <ListItem>
          <ListItem.Content style={styles.item}>
            <ListItem.Title>
              {laptop.id} {laptop.marca}
            </ListItem.Title>
            <ListItem.Subtitle style={styles.separator}>
              {laptop.procesador} <Text>, memoria:</Text> {laptop.memoria}
            </ListItem.Subtitle>
          </ListItem.Content>
        </ListItem>
      </TouchableHighlight>
    );
  };

  return (
    <View style={styles.container}>
      <FlatList
        data={ListaLaptops}
        renderItem={({ item }) => {
          return <ItemLaptops laptop={item}></ItemLaptops>;
        }}
      ></FlatList>
      <FAB
        title="+"
        onPress={() => {
          navigation.navigate("IngresoLaptopsNav", {});
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
