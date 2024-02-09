import { FlatList, StyleSheet, Text, View } from "react-native";
import { Button, ListItem } from "@rneui/base";
import { useState } from "react";
import { getLaptops } from "../rest_Laptops/Laptops";

export const Lista = () => {
  const [ListaLaptops, setListaLaptops] = useState([]);

  refresList = (contactos) => {
    setListaLaptops(contactos);
  };

  const ItemLaptops = ({ laptop }) => {
    return (
      <ListItem>
        <ListItem.Content style={styles.item}>
          <ListItem.Title>
            {laptop.id} {laptop.marca}
          </ListItem.Title>
          <ListItem.Subtitle style={styles.separator}>
            {laptop.procesador}
          </ListItem.Subtitle>
        </ListItem.Content>
      </ListItem>
    );
  };

  return (
    <View>
      <Button
        title="LIST"
        onPress={() => {
          getLaptops(refresList);
        }}
      ></Button>
      <FlatList
        data={ListaLaptops}
        renderItem={({ item }) => {
          return <ItemLaptops laptop={item}></ItemLaptops>;
        }}
      ></FlatList>
    </View>
  );
};
const styles = StyleSheet.create({
  item: {
    backgroundColor: "#F0F5D4",
  },
});
