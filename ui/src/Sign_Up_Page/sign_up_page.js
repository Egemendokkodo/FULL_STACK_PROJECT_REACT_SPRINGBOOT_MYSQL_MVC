
import {useNavigate} from "react-router-dom"
import React, { useState } from 'react'
import { EyeInvisibleOutlined, EyeOutlined } from "@ant-design/icons"
const SignUpPage=() =>{
    const navigate=useNavigate()

    const [password, setPassword] = useState("");
    const [visible, setVisible] = useState(false);
  
    function yazdir(){
        const rePassword_textfield=document.getElementById("rePassword_textfield").value
        const email_textfield=document.getElementById("email_textfield").value
        const password_textfield=document.getElementById("password_textfield").value
        console.log(email_textfield)
        console.log(password_textfield)
        console.log(rePassword_textfield)
    }


    return(

        <div className="page">
            
            <div className="cover">
            <h1>Sign Up</h1>
                



            <input id="email_textfield" type='text' placeholder='email' className='input-email'></input>
            <input id="password_textfield" type={visible ? "text" : "password"} placeholder='password' className='input-password' onChange={(e) => setPassword(e.target.value)}></input>
            <div onClick={() => setVisible(!visible)} className="password-toggle-icon">
                    {
                        visible ? <EyeOutlined /> : <EyeInvisibleOutlined />
                    }
            </div>
            
            
            <input id="rePassword_textfield" type={visible ? "text" : "password"} placeholder='repeat password' className='input-password' onChange={(e) => setPassword(e.target.value)}></input>
            <div onClick={() => setVisible(!visible)} className="re-password-toggle-icon">
                    {
                        visible ? <EyeOutlined /> : <EyeInvisibleOutlined />
                    }
            </div>
            
            
            
            
            

            

            

            <div onClick={() => {yazdir()}} className='login-btn' type="submit">Sign Up</div>
            
            <div className='dont-have-an-account-container'>

            <p> Already have an account?</p>
            <div className='spacer'></div>
            <p className='sign-up-button' onClick={() => navigate("/")}>Sign in</p>
            </div>

            <p className='text'>or sign up using</p>
                

            
                <div className='alt-login'>
                    <button className='circle-btn-google' type="google"></button>
                    <button className="circle-btn-facebook" type="facebook"></button>
                </div>
            </div>

            

            





        </div>









        
    )
}

export default SignUpPage
