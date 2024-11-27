import { Button, TextField } from '@mui/material'
import { ErrorMessage, Field, Form, Formik } from 'formik'
import React, {useState} from 'react'
import { useDispatch } from 'react-redux'
import * as Yup from "yup"
import {loginUserAction} from '../../Redux/Auth/auth.action'


const initialValues={email:"",password:""}
const validationSchema={email:Yup.string().email("Invalid email").required("Email is required"),
    password:Yup.string().min(6,"Password mut be at least 6 characters").required("Password is required")
}
const Login = () => {
    const [formValue,setFormValue]=useState();
    const dispatch=useDispatch();
    const handleSubmit=(values)=>{
        console.log("handle submit",values);
        dispatch(loginUserAction({data:values}))
    };
  return (
    <>
    <Formik  onSubmit={handleSubmit} 
            //  validationSchema={validationSchema} 
             initialValues={initialValues}>
            
            <Form className="space-y-5">
                <div className="space-y-5">
                    <div>
                        <Field as={TextField} name="email" placeholder="Email" type="email" variant="outlined" fullWidth/>
                    <ErrorMessage name="email" component="div" className="text-red-500"/>
                    </div>
                    <div>
                        <Field as={TextField} name="password" placeholder="password" type="password" variant="outlined" fullWidth/>
                    <ErrorMessage name="password" component="div" className="text-red-500"/>
                    </div>
                    <Button sx={{padding:".8rem 0rem"}} fullWidth type="submit" variant="contained" color="primary">
                        Login
                    </Button>
                </div>

            </Form>
        
    </Formik>
    </>
  )
}

export default Login