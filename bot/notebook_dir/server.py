from flask import Flask
a=0
app = Flask(__name__)

@app.route('/')
def hello_world():
    global a
    if (a==0):  
        a=1
        return '90,10,10'
    else:
        a=0
        return '0,0,0'

app.run(host = '0.0.0.0',port=5005)