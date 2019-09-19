modelName = {}
modelName[1] = "Horn"
modelName[2] = "Patch"

app = pf.GetApplication()
app:NewProject()
app:OpenFile("${fileName}")--Horn.fek


    -- Create graphs 

 

    -- Create 3D Views
view = app.Views:Add(app.Models[1].Configurations[1])
view.Plots:Add(app.Models[1].Configurations[1].NearFields[1])
 
    -- Export all graphs in the 'CartesianGraphCollection'
    
    -- Add the surface currents to the 3D view
view = app.Views[1]
my_3Dview_currents_plot = view.Plots:Add(app.Models[1].Configurations[1].SurfaceCurrents[1])

-- Scale the quantity to dB
my_3Dview_currents_plot.Quantity.ValuesScaledToDB = true

for index, graph in pairs(app.Windows) do
    graph:Maximise()
    graph:ExportImage("3D-表面感應電流"..index, "png")
end
