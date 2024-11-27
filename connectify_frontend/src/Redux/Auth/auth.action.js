import axios from "axios"
import { API_BASE_URL } from "../../config/api"
import { LOGIN_FAILURE, LOGIN_REQUEST, LOGIN_SUCCESS} from "./auth.actionType"

export const loginUserAction=(loginData)=>async(dipatch)=>{
    dipatch({type:LOGIN_REQUEST})
    try{
        const {data}=await axios.post(`${API_BASE_URL}/auth/signin`,loginData.data)

        if(data.jwt)
        {
            localStorage.setItem("jwt",data.jwt)
        }
        console.log("login success",data)
        dipatch({type:LOGIN_SUCCESS,payload:data.jwt})

    }
    catch(error)
    {
        console.log("-----------",error)
        dipatch({LOGIN_FAILURE,payload:error})
    }
}



export const registerUserAction=(loginData)=>async(dipatch)=>{
    dipatch({type:LOGIN_REQUEST})
    try{
        const {data}=await axios.post(`${API_BASE_URL}/auth/signup`,loginData.data)

        if(data.jwt)
        {
            localStorage.setItem("jwt",data.jwt)
        }
        console.log("register",data)
        dipatch({type:LOGIN_SUCCESS,payload:data.jwt})

    }
    catch(error)
    {
        console.log("-----------",error)
        dipatch({LOGIN_FAILURE,payload:error})
    }
}