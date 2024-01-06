import { View, StyleSheet } from 'react-native'
import { Button, Text } from '@rneui/base'
import { getAllPostsService, createPostService,updatePostService, getByUserIdService,  } from '../services/TestServices'
import { getAllPostsService1, createPostService1,updatePostService1, getDocumentTypes} from '../services/TestServices'

const getAllPosts = () => {
  getAllPostsService();
}
const getAllPosts1 = () => {
  console.log("nuevo get")
  getAllPostsService1();
}

const createPost = () => {
  createPostService();
}

const createPost1 = () => {
  console.log(" crear post")
  createPostService1();
}

const updatePost = () => {
  updatePostService();
}

const getByUserId  = () => {
  getByUserIdService();
}
const updatePost1 = () => {
  console.log(" crear put")
  updatePostService1();
}

const getDocument = () => {
  getDocumentTypes();
}
export const TestWebServices = ({ navigation }) => {

  return <View style={styles.container}>
    <Text style={styles.textContainer}>Modulo 3</Text>
    <View style={styles.buttonContainer}>
      <Button  buttonStyle={styles.Btn}
        title="Recuperar Posts"
        onPress={getAllPosts}
      />
      <Button  buttonStyle={styles.Btn}
        title="Crear Post"
        onPress={createPost}
      />
      <Button  buttonStyle={styles.Btn}
        title="Actualizar Post"
        onPress={updatePost}
      />
      <Button  buttonStyle={styles.Btn}
        title="Filtrar"
        onPress={getByUserId}
      />
      <Button  buttonStyle={styles.Btn}
        title="get Post 1"
       
        onPress={getAllPosts1}
      />

      <Button  buttonStyle={styles.Btn}
         title="Crear Post 1"
         onPress={createPost1}
      />

      <Button  buttonStyle={styles.Btn}
         title="Actualizar Post 1"
         onPress={updatePost1}
      />
  <Button  buttonStyle={styles.Btn}
         title="TIPOS DE DOCUMENTOS"
         onPress={getDocument}
      />
       <Button   buttonStyle={styles.Btn}
                title="Nuevo"
                onPress={() => {
                    navigation.navigate("PostFormView");
                  }}
            />
    </View>
  </View>
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    backgroundColor: '#fff',
  },
  textContainer: {
    flex: 1,
    textAlign: 'center',
    fontSize: 30,
    marginVertical: 10,
    fontStyle:'italic',
    fontWeight:"bold",
    color:"#E02E07",

  },
  buttonContainer: {
    flex: 6,
    alignItems: 'stretch',
    justifyContent: 'space-around',
    marginHorizontal: 10,
    borderRadius:10,

  },

  Btn: {
   
    backgroundColor:"#6D097F",
    borderRadius:20,
    margin:20,

  }
});