from flask import Flask,jsonify

app = Flask(__name__)

tasks=[
    { 'task_name':'task 1','owner':'Patricio'},
    { 'task_name':'task 2','owner':'Pedro'}
]

@app.route("/")
def hello_world():
    return jsonify({'task': tasks});
    #return "<p>Hello, World!</p>"