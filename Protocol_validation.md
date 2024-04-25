## Details of the independent validation steps performed for the protocols

1. Conda environment created using environment.yml (Python 3.9.0)

2. Initialization steps generated some error messages

    **A. No module named jnius_config**

    `ModuleNotFoundError: No module named 'jnius_config'`

    ***This was fixed by*** `pip install pyimagej` and `pip install imagej`

    **B. No module named matplotlib**

    ***This was fixed by*** `pip install matplotlib`

    **C. Error in initializing Fiji**

    `OSError: Sorry, the interactive mode is not available on macOS.`

    ***This was fixed by removing*** `mode='interactive'` from the code

3. Fiji endpoint version 2.9 was initiated

    `ImageJ2/Fiji version: 2.9.0/1.53t`

4. All legacy ImageJ resources, additional Imagej2/Fiji resources, and JAVA-related resources could be loaded

5. Pipeline params were running after setting the input folder (movies - before and after treatment) and output folder

6. Barbara's protcol
   
`---------------------------------------------------------------------------
ModuleNotFoundError                       Traceback (most recent call last)
Cell In[29], line 1
----> 1 from ij import IJ, WindowManager, ImagePlus
      2 from ij.io import DirectoryChooser
      3 from ij.gui import WaitForUserDialog, GenericDialog`

`ModuleNotFoundError: No module named 'ij'`

7. Ed's code

`---------------------------------------------------------------------------
`ImportError                               Traceback (most recent call last)
Cell In[28], line 7
      5 if f[-4:] == file_type:
      6     name = f.split(".")[0]
----> 7     imp = ij.IJ.openImage(os.path.join(pipeline_params['input_dir'], f))
      8     imp.show()
      9     ij.IJ.selectWindow(name + file_type)

File ~/anaconda3/envs/trd2_protocol/lib/python3.9/site-packages/imagej/__init__.py:777, in GatewayAddons.IJ(self)
    771 @property
    772 def IJ(self):
    773     """Get the original ImageJ `IJ` utility class.
    774 
    775     :return: The `ij.IJ` class.
    776     """
--> 777     return self._access_legacy_class("ij.IJ")

File ~/anaconda3/envs/trd2_protocol/lib/python3.9/site-packages/imagej/__init__.py:804, in GatewayAddons._access_legacy_class(self, fqcn)
    803 def _access_legacy_class(self, fqcn: str):
--> 804     self._check_legacy_active(f"The {fqcn} class is not available.")
    805     class_name = fqcn[fqcn.rindex(".") + 1 :]
    806     property_name = f"_{class_name}"

File ~/anaconda3/envs/trd2_protocol/lib/python3.9/site-packages/imagej/__init__.py:819, in GatewayAddons._check_legacy_active(self, usage_context)
...
    821             f"{usage_context} See: "
    822             "https://github.com/imagej/pyimagej/blob/main/doc/Initialization.md"
    823         )`

`ImportError: The original ImageJ is not available in this environment. The ij.IJ class is not available. `See: https://github.com/imagej/pyimagej/blob/main/doc/Initialization.md`