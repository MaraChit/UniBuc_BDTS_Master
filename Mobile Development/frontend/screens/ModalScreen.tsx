import { StatusBar } from 'expo-status-bar';
import {Button, Platform, StyleSheet, TextInput} from 'react-native';
import * as React from "react";
import { Text, View } from '../components/Themed';
import {User} from "../models/user";
import {createUser, loginUser} from "../api/api";
import AsyncStorage from "@react-native-async-storage/async-storage";
import {useIsSignedIn} from "../hooks/useIsSignedIn";

export default function ModalScreen() {
    const [isLoading, username] = useIsSignedIn();
    const [error, setError] = React.useState<string>("");
    const [user, setUser] = React.useState<User>({username:"", firstName: "", lastName: "", password: ""});
    const [isLoggedIn, setIsLoggedIn] = React.useState<boolean>(false);
    const [displaySignUp, setDisplaySignUp] = React.useState(true)
    React.useEffect(()=>{
      if(isLoading)
          return;
      setIsLoggedIn(username!="");
    },[isLoading, username])

    const storeData = async (username: string): Promise<void> => {
        try {
            await AsyncStorage.setItem('username', username)
            setIsLoggedIn(true);
        } catch (e) {
    console.warn(e)
    }
    }
  const onSignUp = ({user}:{user: User}) : void =>{
    createUser(user).then(response=> {
        if(response.status == 406){
            setError("Invalid user, please try a different username")
        }
        else{
            storeData(user.username);
        }
    })
  }


  const onLogIn = ({user}:{user: User}) : void =>{
    loginUser(user).then(response=> {
        if(response.status == 406){
            setError("User doesn't exist")
        }
        else{
            storeData(user.username);
        }
    })
  }

  const signOut = async () => {
  try {
    await AsyncStorage.removeItem('username')
      setIsLoggedIn(false);
  } catch(e) {
    // remove error
  }

}

  const SignOutComponent = (): JSX.Element => {
        return (
            <>
                <Text>
                    You're already signed in!
                </Text>
                <Button title={"Sign out"} onPress={() => signOut()}/>
            </>
        )
  }

    return (isLoading ? <Text>Loading</Text> :
    <View style={styles.container}>
        {isLoggedIn ? <SignOutComponent/> : displaySignUp ?
            <><Text style={styles.top}>Username</Text>
         <TextInput
          style={styles.input}
          value={user.username.toString()}
          onChangeText={(name: string) => setUser({...user, username: name})}
          placeholder={"username"}
        />
        <Text>First name</Text>
         <TextInput
          style={styles.input}
          value={user.firstName.toString()}
          onChangeText={(name: string) => setUser({...user, firstName: name})}
          placeholder={"first name"}
        />
        <Text>Last Name</Text>
         <TextInput
          style={styles.input}
          value={user.lastName.toString()}
          onChangeText={(name: string) => setUser({...user, lastName: name})}
          placeholder={"last name"}
        />
      <Text>Password</Text>
         <TextInput
          style={styles.input}
          value={user.password.toString()}
          onChangeText={(password: string) => setUser({...user, password: password})}
          placeholder={"password"}
          secureTextEntry
        />
        <Button title={"submit"} onPress={()=>onSignUp({user})}/>
        <Button title={"Already have an account? Log in."} onPress={()=>setDisplaySignUp(false)}/>
        <Text>
            {error}
        </Text>
           </>      :
            <>
            <Text style={styles.top}>Username</Text>
         <TextInput
          style={styles.input}
          value={user.username.toString()}
          onChangeText={(name: string) => setUser({...user, username: name})}
          placeholder={"username"}
        />
        <Text>Password</Text>
         <TextInput
          style={styles.input}
          value={user.password.toString()}
          onChangeText={(password: string) => setUser({...user, password: password})}
          placeholder={"password"}
          secureTextEntry
        />
        <Button title={"submit"} onPress={()=>onLogIn({user})}/>
        <Button title={"Don't have an account? Sign up."} onPress={()=>setDisplaySignUp(true)}/>

        <Text>
            {error}
        </Text>
                </>
}
      <StatusBar style={Platform.OS === 'ios' ? 'light' : 'auto'} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    alignItems: 'center'
  },
    top: {
      marginTop: 55,
    },
  input: {
    height: 50,
    width:150,
    backgroundColor: "#fff",
  }
});
