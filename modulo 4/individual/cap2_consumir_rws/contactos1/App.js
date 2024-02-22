import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { ListaContactos } from "./screens/contactsLis";
import { ContactForm } from "./screens/contactsForm";
export default function App() {
  const StackContat = createNativeStackNavigator();
  return (
    <NavigationContainer>
      <StackContat.Navigator initialRouteName="ContactsListNav">
        <StackContat.Screen
          name="ContactsListNav"
          component={ListaContactos}
        ></StackContat.Screen>
        <StackContat.Screen
          name="ContactsForm"
          component={ContactForm}
        ></StackContat.Screen>
      </StackContat.Navigator>
    </NavigationContainer>
  );
}
