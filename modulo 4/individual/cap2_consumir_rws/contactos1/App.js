import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { ListaContactos } from "./screens/contactsLis";
export default function App() {
  const StackContat = createNativeStackNavigator();
  return (
    <NavigationContainer>
      <StackContat.Navigator>
        <StackContat.Screen
          name="ContactsListNav"
          component={ListaContactos}
        ></StackContat.Screen>
      </StackContat.Navigator>
    </NavigationContainer>
  );
}
