import {
  StyleSheet,
  Text,
  View,
  FlatList,
  TouchableHighlight,
} from "react-native";
import { getNotas } from "../services/gradeService";
import { FAB, ListItem } from "@rneui/base";
import { Avatar } from "@rneui/themed";
import { useState } from "react";

export const ListGradeForm = ({ navigation }) => {
  const [time, setTime] = useState();

  const refreshList = () => {
    setTime(new Date().getTime());
  };
  const ItemNotas = ({ nota }) => {
    return (
      <TouchableHighlight
        onPress={() => {
          navigation.navigate("GradeFormNav", {
            notita: nota,
            fnRefresh: refreshList,
          });
        }}
      >
        <ListItem bottomDivider>
          <Avatar
            title={nota.materia.substring(0, 1)}
            containerStyle={{ backgroundColor: "green" }}
            rounded
          ></Avatar>

          <ListItem.Content>
            <ListItem.Title>{nota.materia}</ListItem.Title>
          </ListItem.Content>
          <ListItem.Content>
            <ListItem.Title>{nota.nota}</ListItem.Title>
          </ListItem.Content>
          <ListItem.Chevron></ListItem.Chevron>
        </ListItem>
      </TouchableHighlight>
    );
  };

  return (
    <View style={styles.container}>
      <FlatList
        data={getNotas()}
        renderItem={({ item }) => {
          return <ItemNotas nota={item}></ItemNotas>;
        }}
        keyExtractor={(item) => {
          return item.materia;
        }}
        extraData={time}
      ></FlatList>

      <FAB
        style={styles.lista}
        title="+"
        placement="right"
        onPress={() => {
          navigation.navigate("GradeFormNav", {
            notita: null,
            fnRefresh: refreshList,
          });
        }}
      ></FAB>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});
