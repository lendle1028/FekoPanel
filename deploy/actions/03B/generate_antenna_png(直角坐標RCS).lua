modelName = {}
modelName[1] = "Horn"
modelName[2] = "Patch"

app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--Horn.fek


    -- Create graphs 
farFieldGraph = app.CartesianGraphs:Add()
farFieldGraph.Traces:Add(app.Models[1].Configurations[1].FarFields[1])
 

    -- Create 3D Views
 
 
    -- Export all graphs in the 'CartesianGraphCollection'

for index, graph in pairs(app.Windows) do
    graph:Maximise()
    graph:ExportImage("2D-RCS示意圖"..index, "png")
end
