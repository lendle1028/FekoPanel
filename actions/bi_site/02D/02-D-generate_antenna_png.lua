modelName = {}
modelName[1] = "shpere_9.4GHz_bi-static"


app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--sphere.fek

    -- Create graphs 
    
farFieldGraph = app.CartesianGraphs:Add()
farFieldGraph.Traces:Add(app.Models[1].Configurations[1].FarFields[1])
nearFieldGraph = app.CartesianGraphs:Add()
nearFieldGraph.Traces:Add(app.Models[1].Configurations[1].NearFields[1])

    -- Create 3D Views
    
view1 = app.Views:Add(app.Models[1].Configurations[1])
view1.Plots:Add(app.Models[1].Configurations[1].FarFields[1])
view2 = app.Views:Add(app.Models[1].Configurations[1])
view2.Plots:Add(app.Models[1].Configurations[1].NearFields[1])

    -- Export all graphs in the 'CartesianGraphCollection'

for index, graph in pairs(app.Windows) do
    graph:Maximise()
    graph:ExportImage("temp_Graph"..index, "png")
end
