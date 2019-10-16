modelName = {}
modelName[1] = "shpere_9.4GHz_bi-static"


app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--sphere.fek


    -- Create graphs 
farFieldGraph = app.CartesianGraphs:Add()
farFieldGraph.Traces:Add(app.Models[1].Configurations[1].FarFields[1])

    -- Export all graphs in the 'CartesianGraphCollection'

for index, graph in pairs(app.Windows) do
    graph:Maximise()
    graph:ExportImage("2D-RCS"..index, "png")
end
