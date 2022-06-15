import AsyncStorage from "@react-native-async-storage/async-storage";
import * as React from "react";
export const useIsSignedIn =  (): [boolean, string] => {
    const [username, setUsername] = React.useState<string>("");
    const [isLoading, setIsLoading] = React.useState(true)
    const getData = async () => {
        try {
            const value = await AsyncStorage.getItem('username')
            setIsLoading(false)
            setUsername(value ? value: "")
            return value !== null;
        }
        catch(e) {
            setIsLoading(false)
        }
    }
    getData();
    return [isLoading, username]
}