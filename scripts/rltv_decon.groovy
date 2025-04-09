#@ OpService ops
#@ Img img
#@ Integer (label = "Iterations:", min = 1, value = 15) iterations
#@ Float (label = "Numerical Aperture:", style = "format:0.00", value = 1.4) numericalAperture
#@ Integer (label = "Wavelength (nm):", min = 0, value = 550) wavelength
#@ Float (label = "Refractive Index (immersion):", style = "format:0.00", value = 1.5) riImmersion
#@ Float (label = "Refractive Index (sample):", style = "format:0.00", value = 1.4) riSample
#@ Float (label = "Lateral resolution (um/pixel):", style = "format:0.0000", min = 0.0, value = 0.065) lateralResolution
#@ Float (label = "Axial resolution (um/pixel):", style = "format:0.0000", min = 0.0, value = 0.1) axialResolution
#@ Float (label = "Particle/sample position (um):", style = "format:0.0000", min = 0.0, value = 0) pZ
#@ Float (label = "Regularization factor:", style = "format:0.00000", min = 0.0, value = 0.002) regularizationFactor
#@output Img psf
#@output Img result

import net.imglib2.FinalDimensions
import net.imglib2.type.numeric.real.FloatType

// convert input image to 32-bit
img = ops.convert().float32(img)

// use image dimensions for PSF size
psf_size = new FinalDimensions(img.dimensionsAsLongArray())

// convert the input parameters to meters
wavelength = wavelength.toFloat() * 1E-9
lateralResolution = lateralResolution * 1E-6
axialResolution = axialResolution * 1E-6
pZ = pZ * 1E-6

// create the synthetic PSF
psf = ops.create().kernelDiffraction(psf_size,
	numericalAperture,
	wavelength,
	riSample,
	riImmersion,
	lateralResolution,
	axialResolution,
	pZ,
	new FloatType())

// deconvolve image
result = ops.deconvolve().richardsonLucyTV(img, psf, iterations, regularizationFactor)
